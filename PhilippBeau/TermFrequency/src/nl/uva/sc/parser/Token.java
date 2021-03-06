package nl.uva.sc.parser;

public class Token implements Comparable<Token> {

    private final String mWord;

    private int mFrequency;

    public Token(final String word) {
        mWord = word;
        mFrequency = 1;
    }

    public Token(final String word, final int frequency) {
        mWord = word;
        mFrequency = frequency;
    }

    public void addFrequency() {
        mFrequency++;
    }

    public String getWord() {
        return mWord;
    }

    public int getFrequency() {
        return mFrequency;
    }

    @Override
    public int hashCode() {
        return mWord.hashCode();
    }

    @Override
    public int compareTo(final Token o) {
        return mFrequency - o.mFrequency;
    }

    @Override
    public String toString() {
        return mWord + " - " + mFrequency;
    }

}
