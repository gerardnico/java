package Java.RegularExpression;


import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gerard on 17-06-2016.
 * Example based on {@link Matcher} and {@link Pattern}
 */
public class RegularExpression {


    @Test
    public void groups() {
        String url = URI.create("sftp://user:password@localhost").toString();
        Pattern pattern = Pattern.compile("(sftp://)([^@]*)(.*)(.*)");
        Matcher matcher = pattern.matcher(url);
        System.out.println("There is " + matcher.groupCount() + " group (ie four ()) in the pattern (" + pattern.toString() + "). This is a static property of the pattern (why a function in the matcher ??)");
        System.out.println();
        // Try to find the first sequence match
        boolean doWeHaveAMatch = matcher.find();
        if (doWeHaveAMatch == true) {
            // Print the matches
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.printf(i + " : " + matcher.group(i));
                if (i == 0) {
                    System.out.printf(" (the index 0 contains the whole string that matches)\n");
                } else {
                    System.out.printf("\n");
                }
            }
        }

    }

    @Test
    public void HierarchyGroupsTest() {


        String sourceText = "<top><node1>content</node1><node2>content</node2></top>" +
                "<top><node1>content2</node1></top>";
        Pattern pattern = Pattern.compile("<top><node1>(.*?)</node1>(<node2>(.*)</node2>)*</top>");

        Matcher matcher = pattern.matcher(sourceText);
        int expectedGroup = 3;
        Assert.assertEquals("There is "+expectedGroup+" groups in this pattern", expectedGroup, matcher.groupCount());

        // Print the matches
        Integer seqCounter = 0;
        // Try to find the first sequence match
        while (matcher.find()) {

            seqCounter++;

            System.out.println();
            System.out.println("Sequence " + seqCounter);

            for (int i = 0; i <= matcher.groupCount(); i++) {

                System.out.printf(i + " : " + matcher.group(i));
                if (i == 0) {
                    System.out.printf(" (the index 0 contains the whole string that matches)\n");
                } else {
                    System.out.printf("\n");
                }
            }

        }
        Assert.assertEquals("There was two matches",Integer.valueOf(2), seqCounter);

    }

}

