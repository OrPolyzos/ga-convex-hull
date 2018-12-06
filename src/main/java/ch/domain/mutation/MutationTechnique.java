package ch.domain.mutation;

public interface MutationTechnique<T> {

    void mutate(T gene);

}
