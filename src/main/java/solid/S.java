package solid;


// Single Responsibility principle

public class S {
    public static void main(String[] args) {

    }
}

/*class Book {
    String name;
    String authorName;
    int year;
    int price;
    String isbn;

    public Book(String name, String authorName, int year, int price, String isbn)  {
        this.name = name;
        this.authorName = authorName;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
    }
}
class Invoice {
    private Book book;
    private int quantity;
    private double discountRate;
    private double taxRate;
    private double total;

    public Invoice(Book book, int quantity, double discountRate, double taxRate, double total) {
        this.book = book;
        this.quantity = quantity;
        this.discountRate = discountRate;
        this.taxRate = taxRate;
        this.total = total;
    }

    public double calculateTotal() {
        double price = ((book.price - book.price * discountRate) * this.quantity);

        double priceWithTaxes = price * (1 + taxRate);

        return priceWithTaxes;
    }

    public void printInvoice() {
        System.out.println(quantity + "x " + book.name + " " +          book.price + "$");
        System.out.println("Discount Rate: " + discountRate);
        System.out.println("Tax Rate: " + taxRate);
        System.out.println("Total: " + total);
    }

    public void saveToFile(String filename) {
        // Creates a file with given name and writes the invoice
    }
}*/

// Bu class da SOLID prinsipini S yani Single Responsibilty prinsiple ini buzyapti.
// Invoice classinda saveToFiles() classga logika nuqtai nazaridan tegishli bolmagan method.
// Single Responsibilty prinsiple : Har bir class bitta narsaga javob berish kerak, bitta maqsadli bo'lish kerak.
// Yuqoridagi classda esa Invoice classida printInvoice va saveToFiles methodlari logika jixatdan mos bo'lmagan metodlardir
// Yana 2 ta classs ochamiz  InvoicePrinter and InvoicePersistence digan.
// Shunda 4 ta class xosil bo'ladi : Book, Invoice, InvoicePrinter, InvoicePersistence

class Book_ {
    String name;
    String authorName;
    int year;
    int price;
    String isbn;

    public Book_(String name, String authorName, int year, int price, String isbn) {
        this.name = name;
        this.authorName = authorName;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
    }
}

class Invoice_ {
    protected Book_ book;
    protected int quantity;
    protected double discountRate;
    protected double taxRate;
    protected double total;

    public Invoice_(Book_ book, int quantity, double discountRate, double taxRate, double total) {
        this.book = book;
        this.quantity = quantity;
        this.discountRate = discountRate;
        this.taxRate = taxRate;
        this.total = total;
    }

    public double calculateTotal() {
        double price = ((book.price - book.price * discountRate) * this.quantity);

        double priceWithTaxes = price * (1 + taxRate);

        return priceWithTaxes;


    }
}

class InvoicePrinter {
    private Invoice_ invoice;

    public InvoicePrinter(Invoice_ invoice) {
        this.invoice = invoice;
    }

    public void print() {
        System.out.println(invoice.quantity + "x " + invoice.book.name + " " + invoice.book.price + " $");
        System.out.println("Discount Rate: " + invoice.discountRate);
        System.out.println("Tax Rate: " + invoice.taxRate);
        System.out.println("Total: " + invoice.total + " $");
    }
}

class InvoicePersistence {
    Invoice_ invoice;

    public InvoicePersistence(Invoice_ invoice) {
        this.invoice = invoice;
    }

    public void saveToFile(String filename) {
        // Creates a file with given name and writes the invoice
    }
}
