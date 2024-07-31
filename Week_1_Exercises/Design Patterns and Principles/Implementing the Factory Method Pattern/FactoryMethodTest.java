package FactoryMethodPatternExample;
public class FactoryMethodTest {
    public static void main(String[] args) {
        // Step 5.1: Create instances of the concrete factory classes
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Step 5.2: Use the factory to create documents
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();

        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();

        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();
    }
}