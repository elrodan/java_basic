public class Printer {
    private String queue = "";
    private int totalPagesCount = 0;
    private int documentsCount = 0;
    private int allDocumentsCount = 0;
    private int allPagesCount = 0;
    private String allDocumentObject = "";

    public void append(String text) {
        append(text, "", 1);
    }

    public void append(String text, String name) {
        append(text, name, 1);
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

    public String getAllDocumentObject() {
        this.allDocumentsCount = allDocumentsCount + documentsCount;
        this.allPagesCount = allPagesCount + totalPagesCount;
        allDocumentObject = "Напечатано " + allDocumentsCount + " документов и " + allPagesCount + " страниц";
        return allDocumentObject;
    }

    public void print() {
        System.out.println("Очередь печати:");
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
        } else {
            System.out.println(queue);
        }
        getAllDocumentObject();
        clear();
    }

    public int getPagesCount() {
        return totalPagesCount;
    }

    public int getDocumentsCount() {
        return documentsCount;
    }

}
