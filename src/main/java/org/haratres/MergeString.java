package org.haratres;

public class MergeString {

    public String merge(String a, String b) {
        validateStrings(a, b);


        StringBuilder mergedString = new StringBuilder();
        int maxStringLength = Math.max(a.length(), b.length());

        for (int i = 0; i < maxStringLength; i++) {
            if (i < a.length()) {
                mergedString.append(a.charAt(i));
                System.out.println(a.charAt(i));
            }
            if (i < b.length()) {
                mergedString.append(b.charAt(i));
                System.out.println(b.charAt(i));
            }
        }
        return mergedString.toString();
    }

    private void validateStrings(String a, String b) {

        if (a.length() > 2500 | a.length() < 1 | b.length() > 2500 | b.length() < 1) {
            throw new IllegalArgumentException("The parameters must be between 1 and 2500 characters");
        }
    }
}
