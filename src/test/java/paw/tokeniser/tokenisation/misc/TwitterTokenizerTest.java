package paw.tokeniser.tokenisation.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import paw.tokeniser.preprocessing.LowerCasePreprocessor;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwitterTokenizerTest {
    private TwitterTokenizer tokenizer;

    @BeforeEach
    public void buildTokenizer(){
        this.tokenizer = new TwitterTokenizer();
        tokenizer.addPreprocessor(new LowerCasePreprocessor());
        tokenizer.setKeepDelimiter(true);
    }

    @Test
    public void emptyText(){
        String[] result = tokenizer.tokenize("");
        assertEquals(1,result.length);
    }

    @Test
    public void oneWordText(){
        String[] result = tokenizer.tokenize("this");
        Assertions.assertEquals(1,result.length);
        Assertions.assertEquals("this",result[0]);
    }


    @Test
    public void twoWordText(){
        String[] result = tokenizer.tokenize("this is");
        Assertions.assertEquals(2,result.length);
        Assertions.assertEquals("this",result[0]);
    }

    @Test
    public void twoLinesText(){
        String[] result = tokenizer.tokenize("this is \n me");
        Assertions.assertEquals(4,result.length);
        Assertions.assertEquals("\n",result[2]);
    }

    @Test
    public void tweet(){
        String[] result = tokenizer.tokenize("What can you do with LSTM? \"The magic of LSTM neural networks\" by @assaadm http://buff.ly/2m0b2pm  #neuralnetworks #machinelearning");
        Assertions.assertEquals(26,result.length);
    }
}