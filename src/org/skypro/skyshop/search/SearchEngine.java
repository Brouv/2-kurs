package org.skypro.skyshop.search;

import java.util.List;

public class SearchEngine {
    private final Searchable[] searchableItems;
    private int currentIndex = 0;

    public SearchEngine(int capacity) {
        this.searchableItems = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (currentIndex < searchableItems.length) {
            searchableItems[currentIndex++] = item;
        } else {
            System.out.println("Место ограничено, невозможно добавить новый продукт или статью");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm().contains(query)) {
                results[resultCount++] = item;
                if (resultCount == 5) {
                    break;
                }
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
