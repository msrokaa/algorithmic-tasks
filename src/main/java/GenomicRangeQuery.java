import com.google.common.collect.ImmutableList;

import static java.lang.System.arraycopy;

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {

        ImmutableList<Nucleotide> nucleotidesAscending = ImmutableList.of(
                        new Nucleotide('T', 4),
                        new Nucleotide('A', 1),
                        new Nucleotide('G', 3),
                        new Nucleotide('C', 2)
                )
                .stream()
                .sorted()
                .collect(ImmutableList.toImmutableList());

        int[] result = new int[P.length];
        int[][] prefixSums = getPrefixSums(S, nucleotidesAscending);

        for (int i = 0; i < P.length; i++) {
            int startIndex = P[i];
            int endIndex = Q[i];

            for (int j = 0; j < nucleotidesAscending.size(); j++) {
                if (prefixSums[endIndex][j] - (startIndex > 0 ? prefixSums[startIndex - 1][j] : 0) > 0) {
                    result[i] = j + 1;
                    break;
                }
            }
        }

        return result;
    }

    private int[][] getPrefixSums(
            String dnaSequence,
            ImmutableList<Nucleotide> nucleotides
    ) {
        int[][] prefixSums = new int[dnaSequence.length()][nucleotides.size()];

        for (int i = 0; i < dnaSequence.length(); i++) {
            if (i > 0) {
                arraycopy(
                        prefixSums[i - 1],
                        0,
                        prefixSums[i],
                        0,
                        nucleotides.size()
                );
            }
            Nucleotide nucleotide = getNucleotideByName(nucleotides, dnaSequence.charAt(i));
            prefixSums[i][nucleotides.indexOf(nucleotide)] += 1;
        }

        return prefixSums;
    }

    private Nucleotide getNucleotideByName(
            ImmutableList<Nucleotide> nucleotides,
            char nameToGetBy
    ) {
        for (Nucleotide nucleotide : nucleotides) {
            if (nucleotide.getName() == nameToGetBy) {
                return nucleotide;
            }
        }
        return null;
    }

    private static class Nucleotide implements Comparable<Nucleotide> {

        private final char name;
        private final int factor;

        public Nucleotide(char name, int factor) {
            this.name = name;
            this.factor = factor;
        }

        public char getName() {
            return name;
        }

        public int getFactor() {
            return factor;
        }

        @Override
        public int compareTo(Nucleotide nucleotide) {
            return Integer.compare(this.getFactor(), nucleotide.getFactor());
        }
    }
}