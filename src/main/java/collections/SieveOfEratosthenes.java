package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SieveOfEratosthenes {
    private Set<Integer> sieve;
    private Integer limitNumber;

    public SieveOfEratosthenes(Integer limitNumber){
        this.limitNumber = limitNumber;
        sieve = new HashSet<>();
        fillSieve(this.limitNumber);
        removeMultipliesOfNumbers();
        System.out.println(sieve);
    }

    private void fillSieve(Integer limitNumber){
        for(int i = 2; i <= limitNumber; i ++){
            sieve.add(i);
        }
    }

    private void removeMultipliesOfNumbers(){
        Iterator<Integer> iteratorAnalysedNumber;
        Iterator<Integer> iteratorPrimeNumber;

        int actualPrime = 2;
        while(actualPrime*actualPrime < limitNumber){
            iteratorAnalysedNumber = sieve.iterator();

            while(iteratorAnalysedNumber.hasNext()) {
                int analysedNumber = iteratorAnalysedNumber.next();
                if (conditionsToRemoveNumber(actualPrime, analysedNumber)) {
                    iteratorAnalysedNumber.remove();
                }
            }

            iteratorPrimeNumber = sieve.iterator();
            int analysedPrime = iteratorPrimeNumber.next();
            while(iteratorPrimeNumber.hasNext() && analysedPrime <= actualPrime){
                analysedPrime = iteratorPrimeNumber.next();
            }
            actualPrime = analysedPrime;
        }
    }

    private boolean conditionsToRemoveNumber(Integer actualPrime, Integer analysedNumber){
        if(analysedNumber == actualPrime) return false;
        if(analysedNumber == actualPrime*actualPrime) return true;
        for(int increment = 1; increment < limitNumber; increment ++ ){
            if(analysedNumber == actualPrime*(actualPrime + increment)) return true;
        }
        return false;
    }

    public Set<Integer> getSieve(){
        return sieve;
    }

}
