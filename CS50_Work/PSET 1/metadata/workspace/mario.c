{"changed":true,"filter":false,"title":"mario.c","tooltip":"/mario.c","value":"#include <stdio.h>\n#include <cs50.h>\n\n/* Prompt user for height of pyramid */\nint ask_height(void)\n{\n    int height;\n    \n    do \n    {\n        printf(\"Height: \");\n        height = GetInt();\n    }\n    while (height < 0 || height > 23);\n    \n    return height;\n}\n\n/* Print a pyramind given the height as an integer */\nvoid print_pyramid(int height)\n{\n    // calculate width of the pyramid in characters\n    int width = height + 1;\n    \n    // Print the pyramid\n    /* The first row has 2 bricks, and the number of spaces is the width of the\n     * pyramid minus these two bricks. With each iteration of the loop, the\n     * number of bricks increases by one, and the number of spaces decreases\n     * by one, until the bricks take up the entire width of the pyramid\n     */\n    for (int pounds = 2, spaces = width - 2; pounds <= width; pounds++, spaces--)\n    {\n        for (int i = 0; i < spaces; i++)\n        {\n            printf(\" \");\n        }\n        \n        for (int j = 0; j < pounds; j++)\n        {\n            printf(\"#\");\n        }\n        printf(\"\\n\");\n    }\n}\n\nint main(void)\n{\n    int height = ask_height();\n    print_pyramid(height);\n}","undoManager":{"mark":-2,"position":0,"stack":[[{"start":{"row":0,"column":0},"end":{"row":49,"column":1},"action":"insert","lines":["#include <stdio.h>","#include <cs50.h>","","/* Prompt user for height of pyramid */","int ask_height(void)","{","    int height;","    ","    do ","    {","        printf(\"Height: \");","        height = GetInt();","    }","    while (height < 0 || height > 23);","    ","    return height;","}","","/* Print a pyramind given the height as an integer */","void print_pyramid(int height)","{","    // calculate width of the pyramid in characters","    int width = height + 1;","    ","    // Print the pyramid","    /* The first row has 2 bricks, and the number of spaces is the width of the","     * pyramid minus these two bricks. With each iteration of the loop, the","     * number of bricks increases by one, and the number of spaces decreases","     * by one, until the bricks take up the entire width of the pyramid","     */","    for (int pounds = 2, spaces = width - 2; pounds <= width; pounds++, spaces--)","    {","        for (int i = 0; i < spaces; i++)","        {","            printf(\" \");","        }","        ","        for (int j = 0; j < pounds; j++)","        {","            printf(\"#\");","        }","        printf(\"\\n\");","    }","}","","int main(void)","{","    int height = ask_height();","    print_pyramid(height);","}"],"id":1}]]},"ace":{"folds":[],"scrolltop":411,"scrollleft":0,"selection":{"start":{"row":49,"column":1},"end":{"row":49,"column":1},"isBackwards":false},"options":{"guessTabSize":true,"useWrapMode":false,"wrapToView":true},"firstLineState":{"row":28,"state":"comment","mode":"ace/mode/c_cpp"}},"timestamp":1498954545131}