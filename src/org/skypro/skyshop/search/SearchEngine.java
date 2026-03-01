package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Product> searchableItems;
    public SearchEngine() {
        this.searchableItems = new ArrayList<>();
    }

    public List<Product> search(String query) {
        List<Product> results = new ArrayList<>();
        for (Product product : searchableItems) {
            if (product.getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(product);
            }
        }
        return results;
    }
    public Searchable findBestMatch(String search, List<Searchable> items) throws BestResultNotFound {
        if (items == null || items.isEmpty()) {
            throw new BestResultNotFound("Не найдено информации для запроса: '" + search + "'");
        }

        Searchable bestMatch = null;
        int maxOccurrences = -1;

        for (Searchable item : items) {
            String term = item.getSearchTerm();
            int occurrences = countOccurrences(term, search);

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = item;
            }
        }

        if (bestMatch == null || maxOccurrences == 0) {
            throw new BestResultNotFound("Не найдено информации для запроса: '" + search + "'");
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String substring) {
        if (substring == null || substring.isEmpty() || text == null) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }
}
