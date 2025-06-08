package org.skypro.skyshop.search;

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
}
