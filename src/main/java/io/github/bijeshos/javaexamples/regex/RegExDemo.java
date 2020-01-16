package io.github.bijeshos.javaexamples.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExDemo {
    public static void main(String[] args) {
        /*
            Note:
            *	Match the preceding character or subexpression 0 or more times
            +	Match the preceding character or subexpression 1 or more times
            ?	Match the preceding character or subexpression 0 or 1 times
        */
        checkCompleteMatch();
        checkMatchingSubSequence1();
        checkMatchingSubSequence2();
        usingGreedyMatching();
        usingClassOfCharacters();
        usingCaptureGroups();
        misc();
        withFlags();
        notMatching();
        specialCases();
        usingCaptureGroups();
    }

    public static void checkCompleteMatch() {
        String input = "this is a test string";
        Pattern pattern = Pattern.compile("a+");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {   //returns true if input sequence precisely matches pattern (as a whole)
            System.out.println("Input matches with pattern");
        } else {
            System.out.println("Input do not match with pattern");
        }
    }

    public static void checkMatchingSubSequence1() {
        String input = "this is a test string aand another random word aaah";
        Pattern pattern = Pattern.compile("a+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println("Matching sub sequence at index:" + matcher.start() + " :: " + matcher.group());
        }
    }

    public static void checkMatchingSubSequence2() {
        String input = "this is a test string aand another random word aaah";
        //Pattern pattern = Pattern.compile("a{2}");  //exactly two times
        //Pattern pattern = Pattern.compile("a{2,}");  //minimum two times
        Pattern pattern = Pattern.compile("a{1,2}");  //between 1 and 2, inclusive
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println("Matching sub sequence at index:" + matcher.start() + " :: " + matcher.group());
        }
    }

    public static void usingGreedyMatching() {
        String input = "extend cup end table";
        Pattern pattern = Pattern.compile("e.+d");  //by default, greedy behaviour, finds largest match
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println("Matching sub sequence at index:" + matcher.start() + " :: " + matcher.group());
        }
    }

    public static void usingLazyMatching() {
        String input = "extend cup end table";
        Pattern pattern = Pattern.compile("e.+?d");  //? make it reluctant/lazy behaviour, finds shortest match(es)
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println("Matching sub sequence at index:" + matcher.start() + " :: " + matcher.group());
        }
    }

    public static void usingClassOfCharacters() {
        String input = "extend cup end table";
        Pattern pattern = Pattern.compile("[a-z]+");  //class of characters
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println("Matching sub sequence at index:" + matcher.start() + " :: " + matcher.group());
        }
    }

    public static void usingCaptureGroups() {
        String input = "abcd800-555-1234wxyz800-666-7777blahblah900-555-6666";
        Pattern pattern = Pattern.compile("(\\d{3})-(\\d{3})-(\\d{4})");  //\d{3}-\d{3}-\d{4}
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println("Matching sub sequence at index:" + matcher.start() + " :: " + matcher.group());
            System.out.println("Matching group 1 :: " + matcher.group(1));  //group(0) is same as group() ie. all match
            System.out.println("Matching group 2 :: " + matcher.group(2));
            System.out.println("Matching group 3 :: " + matcher.group(3));
        }
    }

    public static void misc() {
        System.out.println("replace all test 1:" + "???".replaceAll("\\?", "!"));
        System.out.println("split test 1:" + Arrays.asList("a|b".split("\\|")));
    }

    public static void withFlags() {
        Pattern pattern = Pattern.compile("foo.", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        System.out.println(pattern.matcher("FOO\n").matches()); // Is true.

        /* Had the regex not been compiled case insensitively and singlelined,
         * it would fail because FOO does not match /foo/ and \n (newline)
         * does not match /./.
         */
        Pattern anotherPattern = Pattern.compile("(?si)foo");
        anotherPattern.matcher("FOO\n").matches(); // Is true.
        System.out.println("foOt".replaceAll("(?si)foo", "ca")); // Returns "cat".
    }

    public static void notMatching() {
        //not matching "popcorn"
        String regexString = "^(?!popcorn).*$";
        System.out.println("[popcorn] " + ("popcorn".matches(regexString) ? "matched!" : "nope!"));
        System.out.println("[unicorn] " + ("unicorn".matches(regexString) ? "matched!" : "nope!"));
    }

    public static void specialCases() {
        //Escaping backslash \  -- requires four backward slashes
        System.out.println("\\".matches("\\\\")); // true
    }
    //Note:
    /*
        ?	Match the preceding character or subexpression 0 or 1 times. Also used for non-capturing groups, and named
         capturing groups.
        *	Match the preceding character or subexpression 0 or more times.
        +	Match the preceding character or subexpression 1 or more times.
        {n}	Match the preceding character or subexpression exactly n times.
        {min,}	Match the preceding character or subexpression min or more times.
        {,max}	Match the preceding character or subexpression max or fewer times.
        {min,max}	Match the preceding character or subexpression at least min times but no more than max times.
        -	when included between square brackets indicates to; e.g. [3-6] matches characters 3, 4, 5, or 6.
        ^	start of string (or start of line if the multiline /m option is specified), or negates a list of options
        (i.e. if within square brackets [])
        $	end of string (or end of line if the multiline /m option is specified).
        (...)	groups subexpressions, captures matching content in special variables (\1, \2, etc.) that can be used
        later within the same regex, for example (\w+)\s\1\s matches word repetition
        (?:...)	groups subexpressions without capturing
        .	matches any character except line-feed (\n).
        [...]	any character between these brackets should be matched once. NB: ^ following the open bracket negates
        this effect.  - occurring inside the brackets allows a range of values to be specified (unless it's the first
         or last character, in which case it just represents a regular dash).
        \	escapes the following character. Also used in meta sequences - regex tokens with special meaning.
        \$	dollar (i.e. an escaped special character)
        \(	open parenthesis (i.e. an escaped special character)
        \)	close parenthesis (i.e. an escaped special character)
        \*	asterisk (i.e. an escaped special character)
        \.	dot (i.e. an escaped special character)
        \?	question mark (i.e. an escaped special character)
        \[	left (open) square bracket (i.e. an escaped special character)
        \\	backslash (i.e. an escaped special character)
        \]	right (close) square bracket (i.e. an escaped special character)
        \^	caret (i.e. an escaped special character)
        \{	left (open) curly bracket / brace (i.e. an escaped special character)
        \|	pipe (i.e. an escaped special character)
        \}	right (close) curly bracket / brace (i.e. an escaped special character)
        \+	plus (i.e. an escaped special character)
        \a	alarm
        \b	word (alphanumeric sequence) boundary
        \1,\2, etc.	back-references to previously matched subexpressions, grouped by (), \1 means first match, \2
        means second match etc.
        [\b]	backspace - when \b is inside a character class ( [] )matches backspace
        \B	negated \b - matches at any position between two word characters as well as at any position between two
        non-word characters
        \D	non-digit
        \d	digit
        \e	escape
        \f	form feed
        \n	line feed
        \r	carriage return
        \S	non-white-space
        \s	white-space
        \t	tab
        \v	vertical tab
        \W	non-word
        \w	word (i.e. alphanumeric character)
        {...}	named character set
        |	or; i.e. delineates the prior and preceding options.

*/
}
