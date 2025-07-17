package io.github.drclass.challenges.problems.rosalind.utils;

public enum Codon {
    A(71.03711),
    C(103.00919),
    D(115.02694),
    E(129.04259),
    F(147.06841),
    G(57.02146),
    H(137.05891),
    I(113.08406),
    K(128.09496),
    L(113.08406),
    M(131.04049),
    N(114.04293),
    P(97.05276),
    Q(128.05858),
    R(156.10111),
    S(87.03203),
    T(101.04768),
    V(99.06841),
    W(186.07931),
    Y(163.06333),
    STOP(0.0);

    private final double MASS;

    Codon(double mass) {
        this.MASS = mass;
    }

    public double getMass() {
        return this.MASS;
    }

    public static Codon fromNucleotides(String sequence) {
        // There has got to be a better option for this...
        return switch (sequence) {
            case "UUU", "UUC" -> F;
            case "UUA", "UUG", "CUU", "CUC", "CUA", "CUG" -> L;
            case "UCU", "UCC", "UCA", "UCG", "AGU", "AGC" -> S;
            case "UAU", "UAC" -> Y;
            case "UGU", "UGC" -> C;
            case "UGG" -> W;
            case "CCU", "CCC", "CCA", "CCG" -> P;
            case "CAU", "CAC" -> H;
            case "CAA", "CAG" -> Q;
            case "CGU", "CGC", "CGA", "CGG", "AGA", "AGG" -> R;
            case "AUU", "AUC", "AUA" -> I;
            case "AUG" -> M;
            case "ACU", "ACC", "ACA", "ACG" -> T;
            case "AAU", "AAC" -> N;
            case "AAA", "AAG" -> K;
            case "GUU", "GUC", "GUA", "GUG" -> V;
            case "GCU", "GCC", "GCA", "GCG" -> A;
            case "GAU", "GAC" -> D;
            case "GAA", "GAG" -> E;
            case "GGU", "GGC", "GGA", "GGG" -> G;
            case "UAA", "UAG", "UGA" -> STOP;
            default -> throw new IllegalStateException("Unexpected value: " + sequence);
        };
    }
}
