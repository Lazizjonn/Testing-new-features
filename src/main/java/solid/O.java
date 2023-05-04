package solid;

// Open - Closed principle

public class O {
    public static void main(String[] args) {

    }
}

class InvoicePersistenceOld {
    Invoice_ invoice;

    public InvoicePersistenceOld(Invoice_ invoice) {
        this.invoice = invoice;
    }

    public void saveToFile(String fileName) {
        // Creates a file with given name and writes the invoice
    }

    public void saveToDatabase() {
        // Saves the invoice to database
    }
}

interface InvoicePersistence__ {
    public void save(Invoice_ invoice);
}

class DatabasePersistence implements InvoicePersistence__ {

    @Override
    public void save(Invoice_ invoice) {
        // Save to Database
    }
}

class FilePersistence implements InvoicePersistence__ {

    @Override
    public void save(Invoice_ invoice) {
        // Save to file
    }
}
