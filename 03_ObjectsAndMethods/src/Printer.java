public class Printer {
    private String queue = "";
    private int totalPagesCount = 0;
    private int documentsCount = 0;
    private String allDocumentObject = "";

    public void append(String text) {
        this.queue = this.queue + "\n" + text;
        this.documentsCount = documentsCount + 1;
    }

    public void append(String text, String name) {
        this.queue = this.queue + "\n" + text + " '" + name + "'"  ;
        this.documentsCount = documentsCount + 1;
    }

    public void append(String text, String name, int pagesCount) {
        this.queue = this.queue + "\n" + text + " '" + name + "'" + " - " + pagesCount + " стр.";
        this.totalPagesCount = totalPagesCount + pagesCount;
        this.documentsCount = documentsCount + 1;
    }

    public void clear() {
        this.queue = "";
        this.totalPagesCount = 0;
        this.documentsCount = 0;
    }

    public void print() {
        System.out.println("Очередь печати:");
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
        } else {
            System.out.println(queue);
        }
        allDocumentObject = "Напечатано " + documentsCount + " документов и " + totalPagesCount + " страниц";
        System.out.println(allDocumentObject);
        clear();
    }

    public int getPagesCount() {
        return totalPagesCount;
    }

    public int getDocumentsCount() {
        return documentsCount;
    }

}
