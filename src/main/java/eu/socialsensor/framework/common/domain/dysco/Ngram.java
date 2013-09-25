package eu.socialsensor.framework.common.domain.dysco;

import com.google.gson.annotations.SerializedName;

/**
*
* @author cmartin - email: c.j.martin-dancausa@rgu.ac.uk
*/
public class Ngram {

    @SerializedName(value = "term")
    private String term;
    @SerializedName(value = "score")
    private Float score;

    public Ngram(String term, Float score) {
        this.term = term;
        this.score = score;
    }

    /**
     * @return the term
     */
    public String getTerm() {
        return term;
    }

    /**
     * @param term the term to set
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * @return the score
     */
    public Float getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     *
     * @param score the score to set
     * @param index index of the score
     */
    /*public void setScore(Float score, int index) {
        if (index >= this.score.length) {
            return;
        }

        this.score[index] = score;
    }

    public Float getScore(int index) {
        if (index >= this.score.length) {
            return null;
        }

        return this.score[index];
    }*/

    public String GetNgramTextNoSpaceCapitalize() {
        String[] terms = term.split(" ");
        String ngramText = new String();
        for (int i = 0; i < terms.length; i++) {
            if (terms[i].equals("_")) {
                continue;
            }

            ngramText += Character.toUpperCase(terms[i].charAt(0)) + terms[i].substring(1);
        }
        return ngramText;
    }

    public boolean equals(Object ngram) {
        //check for self-comparison
        if (this == ngram) {
            return true;
        }

        //use instanceof instead of getClass here for two reasons
        //1. if need be, it can match any supertype, and not just one class;
        //2. it renders an explict check for "that == null" redundant, since
        //it does the check for null already - "null instanceof [type]" always
        //returns false. (See Effective Java by Joshua Bloch.)
        if (!(ngram instanceof Ngram)) {
            return false;
        }
        //Alternative to the above line :
        //if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

        //cast to native object is now safe
        Ngram ngram1 = (Ngram) ngram;

        //now a proper field-by-field evaluation can be made
        return ngram1.getTerm().equals(this.getTerm());
    }

    public int hashCode() {
        int result = 17;

        result = 31 * result + (term != null ? term.hashCode() : 0);
        //result = 31 * result + score;
        return result;
    }

    @Override
    public String toString() {
        return "Ngram [term=" + term + ", score=" + score.floatValue() + "]";
    }
}
