package model;

import java.util.Comparator;

public class TechProductPriceComparator implements Comparator<TechWare> {

    @Override
    public int compare(TechWare t1, TechWare t2){
        int comparison = t1.getProductName().compareTo(t2.getProductName());

        if(comparison == 0){
            comparison = (int) (t1.getPrice() - t2.getPrice());
        }

        return comparison;
    }
}
