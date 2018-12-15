import org.biojava.nbio.core.alignment.matrices.SubstitutionMatrixHelper;
import org.biojava.nbio.core.alignment.template.SequencePair;
import org.biojava.nbio.core.alignment.template.SubstitutionMatrix;
import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.compound.AmbiguityDNACompoundSet;
import org.biojava.nbio.core.sequence.compound.NucleotideCompound;

public class Main {

    public static void main(String[] args) {
        try {
            DNASequence first = new DNASequence("AGCCAGG", AmbiguityDNACompoundSet.getDNACompoundSet());
            DNASequence second = new DNASequence("ATASGCC", AmbiguityDNACompoundSet.getDNACompoundSet());
            System.out.println(first);
            int[][] costMatrix = {{1,2,3,4,5}, {1,2,3,4,5},
                    {1,2,3,4,5},{1,2,3,4,5}, {1,2,3,4,5}};


            // local alligment
            SubstitutionMatrix<NucleotideCompound> matrix = SubstitutionMatrixHelper.getNuc4_4();

            SequencePair<DNASequence, NucleotideCompound> psa =
               Alignments.getPairwiseAlignment(first, second,
                                           PairwiseSequenceAlignerType.LOCAL, null, matrix);

        } catch (CompoundNotFoundException e) {
            e.printStackTrace();
        }
    }
}
