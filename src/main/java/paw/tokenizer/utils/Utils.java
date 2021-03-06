/**
 * Copyright 2017 Matthieu Jimenez.  All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package paw.tokenizer.utils;

import paw.PawConstants;
import paw.tokenizer.token.Token;

import java.util.List;

public class Utils {

    public String rebuild(List<Token> tokens) {
        StringBuilder sb = new StringBuilder();
        byte previous = PawConstants.DELIMITER_TOKEN;
        for (int i = 0; i < tokens.size(); i++) {
            Token tok = tokens.get(i);
            byte type = tok.getType();
            if (type != PawConstants.DELIMITER_TOKEN && previous != PawConstants.DELIMITER_TOKEN) {
                sb.append("");
            }
            sb.append(tok.getToken());
            previous = type;
        }
        return sb.toString();
    }

    public static boolean isNumericArray(String str) {
        if (str == null)
            return false;
        char[] data = str.toCharArray();
        if (data.length <= 0)
            return false;
        int index = 0;
        if (data[0] == '-' && data.length > 1)
            index = 1;
        for (; index < data.length; index++) {
            if (data[index] < '0' || data[index] > '9') // Character.isDigit() can go here too.
                return false;
        }
        //size of long (javascript long are 53bits)
        return str.length() < 10;
    }
}
