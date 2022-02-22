import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void interpret(char[] input) throws IOException { //adapted from https://github.com/elPytel/BF_interpreter/blob/main/bf.c
    int index = 0;

    char current_char;
    int i;
    long loop;

    long[] tape = new long[3000];
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    for (i = 0; i < input.length; i++) {
      current_char = input[i];
      if (current_char == '>') {
        ++index;
      } else if (current_char == '<') {
        --index;
      } else if (current_char == '+') {
        tape[index]++;
      } else if (current_char == '-') {
        tape[index]--;
      } else if (current_char == '.') {
        System.out.print((char) tape[index]);
      } else if (current_char == ',') {
        tape[index] = (char) sc.read();
      } else if (current_char == '[' && tape[index] == 0) { // jump behind loop
        loop = 1;
        while (loop > 0) {
          current_char = input[++i];
          if (current_char == '[') {
            loop++;
          } else if (current_char == ']') {
            loop--;
          }
        }
      } else if (current_char == ']' && tape[index] != 0) { // repeat loop
        loop = 1;
        while (loop > 0) {
          current_char = input[--i];
          if (current_char == '[') {
            loop--;
          } else if (current_char == ']') {
            loop++;
          }
        }
      }
    }
  }


  public static void main(String[] args) {
    String cool = """
            >++++++++[<+++++++++>-]<.
            >++++[<+++++++>-]<+.
            +++++++..
            +++.
            >>++++++[<+++++++>-]<++.
            ------------.
            >++++++[<+++++++++>-]<+.
            <.
            +++.
            ------.
            --------.
            >>>++++[<++++++++>-]<+.""";
    coolinterpret(cool.toCharArray(), cool.length());
  }

  public static void coolinterpret(char[] input, int length) {
    int index = 0;
    char current_char;
    int loop;
    long[] tape = new long[3000];
    int i = 0;
    char greaterthan;
    char lessthan;

    // Right Arrow Check

    while (length-->i) {
      length = length + 1;
      current_char = input[i];
      int notdone = 2;
      int condnotpass = 2;

      while (0 <-- notdone) {
        greaterthan = '>' + 2;
        while (current_char <-- greaterthan) {
          current_char = (char) (current_char + 1);
          lessthan = '>' - 1;
          while (lessthan <-- current_char) {
            index = index + 1;
            condnotpass = 0;
          }
        }
        notdone = 0;
      }
      while (0 <-- condnotpass) {
        notdone = 2;
      }
      condnotpass = 2;

      // Left arrow check

      while (0 <-- notdone) {
        greaterthan = '<' + 2;
        while (current_char <-- greaterthan) {
          current_char = (char) (current_char + 1);
          lessthan = '<' - 1;
          while (lessthan <-- current_char) {
            index = index - 1;
            condnotpass = 0;
          }
        }
        notdone = 0;
      }
      while (0 <-- condnotpass) {
        notdone = 2;
      }
      condnotpass = 2;

      // Plus check

      while (0 <-- notdone) {
        greaterthan = '+' + 2;
        while (current_char <-- greaterthan) {
          current_char = (char) (current_char + 1);
          lessthan = '+' - 1;
          while (lessthan <-- current_char) {
            tape[index] = tape[index] + 1;
            condnotpass = 0;
          }
        }
        notdone = 0;
      }
      while (0 <-- condnotpass) {
        notdone = 2;
      }
      condnotpass = 2;

      // Minus check

      while (0 <-- notdone) {
        greaterthan = '-' + 2;
        while (current_char <-- greaterthan) {
          current_char = (char) (current_char + 1);
          lessthan = '-' - 1;
          while (lessthan <-- current_char) {
            tape[index] = tape[index] - 1;
            condnotpass = 0;
          }
        }
        notdone = 0;
      }
      while (0 <-- condnotpass) {
        notdone = 2;
      }
      condnotpass = 2;

      // Period check

      while (0 <-- notdone) {
        greaterthan = '.' + 2;
        while (current_char <-- greaterthan) {
          current_char = (char) (current_char + 1);
          lessthan = '.' - 1;
          while (lessthan <-- current_char) {
            System.out.print((char) tape[index]);
            condnotpass = 0;
          }
        }
        notdone = 0;
      }
      while (0 <-- condnotpass) {
        notdone = 2;
      }
      condnotpass = 2;

      // Jump to end of loop check

      while (0 <-- notdone) {
        greaterthan = '[' + 2;
        while (current_char <-- greaterthan) {
          current_char = (char) (current_char + 1);
          lessthan = '[' - 1;
          while (lessthan <-- current_char) {
            // we've verified that current_char == '['

            long gettape = tape[index];
            int two = 2;
            int negone = -2;
            while (gettape <-- two) {
              gettape = gettape + 1;
              while (negone <-- gettape) {
                // we've verified that tape[index] == 0
                loop = 1;
                while (-1 <-- loop) {
                  int innercondnotpass = 2;
                  int innernotdone = 2;
                  loop = loop + 1;
                  i = i + 1;
                  current_char = input[i];
                  while (0 <-- notdone) {
                    greaterthan = '[' + 2;
                    while (current_char <-- greaterthan) {
                      current_char = (char) (current_char + 1);
                      lessthan = '[' - 1;
                      while (lessthan <-- current_char) {
                        loop = loop + 1;
                        innercondnotpass = 0;
                      }
                    }
                    innernotdone = 0;
                  }
                  while (0 <-- innercondnotpass) {
                    innernotdone = 2;
                  }
                  while (0 <-- innernotdone) {
                    greaterthan = ']' + 2;
                    while (current_char <-- greaterthan) {
                      current_char = (char) (current_char + 1);
                      lessthan = ']' - 1;
                      while (lessthan <-- current_char) {
                        loop = loop - 1;
                      }
                    }
                    innernotdone = 0;
                  }
                }
                gettape = -1;
              }
              gettape = 1;
            }
            condnotpass = 0;
          }
        }
        notdone = 0;
      }
      while (0 <-- condnotpass) {
        notdone = 2;
      }

      //Jump to beginning of loop check

      while (0 <-- notdone) {
        greaterthan = ']' + 2;
        while (current_char <-- greaterthan) {
          current_char = (char) (current_char + 1);
          lessthan = ']' - 1;
          while (lessthan <-- current_char) {
            int num = 500;
            long gettape = tape[index];
            int cmpgt = 2;
            while (gettape <-- cmpgt) {
              gettape = gettape + 1;
              int cmplt = -1;
              while (cmplt <-- gettape) {
                num = 0;
              }
            }
            int lownum = 69;
            while (lownum <-- num) { // If gettape != 0
              num = 0;
              loop = 1;
              while (loop --> 0) {
                int innercondnotpass = 2;
                int innernotdone = 2;
                loop = loop + 1;
                i = i - 1;
                current_char = input[i];
                while (0 <-- innernotdone) {
                  greaterthan = '[' + 2;
                  while (current_char <-- greaterthan) {
                    current_char = (char) (current_char + 1);
                    lessthan = '[' - 1;
                    while (lessthan <-- current_char) {
                      loop = loop - 1;
                      innercondnotpass = 0;
                    }
                  }
                  innernotdone = 0;
                }
                while (0 <-- innercondnotpass) {
                  innernotdone = 2;
                }
                while (0 <-- innernotdone) {
                  greaterthan = ']' + 2;
                  while (current_char <-- greaterthan) {
                    current_char = (char) (current_char + 1);
                    lessthan = ']' - 1;
                    while (lessthan <-- current_char) {
                      loop = loop + 1;
                    }
                  }
                  innernotdone = 0;
                }
              }
            }
          }
        }
        notdone = 0;
      }
      i = i + 1;
    }
  }
}
