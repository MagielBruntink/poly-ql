package nl.uva.sc.parser;

public class Token implements Comparable<Token> {

    private final String mToken;

    private int mFrequency = 1;

    public Token(final String token) {
        mToken = token;
    }

    public void addOccurrence() {
        mFrequency++;
    }

    @Override
    public int hashCode() {
        return mToken.hashCode();
    }

    @Override
    public int compareTo(final Token o) {
        return mFrequency - o.mFrequency;
    }

}
