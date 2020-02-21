package ru.itmo.catalog;

import ru.itmo.exceptions.CatalogLoadException;
import ru.itmo.exceptions.ItemAlreadyExistsException;
import ru.itmo.models.FoodItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CatalogFileLoader implements CatalogLoader {
    String fileName;

    public CatalogFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void load(ItemCatalog catalog) throws CatalogLoadException {
        File file = new File(fileName);
        FileInputStream fileInputStream;
        String line;

        try {
            fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(fileInputStream);

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();

                if (line.length() == 0) {
                    break;
                }

                String[] fields = line.split(";");
                String name = fields[0];
                float price = Float.parseFloat(fields[1]);
                short expires = Short.parseShort(fields[2]);

                catalog.addItem(new FoodItem(name, price, expires));
            }

        } catch (FileNotFoundException | ArrayIndexOutOfBoundsException |
                ItemAlreadyExistsException | NumberFormatException ex )
        {
            throw new CatalogLoadException(ex);
        }
    }
}
