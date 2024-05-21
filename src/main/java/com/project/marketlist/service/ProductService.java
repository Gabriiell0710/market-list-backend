package com.project.marketlist.service;
import com.lowagie.text.*;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.project.marketlist.controller.ProductResponseController;
import com.project.marketlist.model.ProductModel;
import com.project.marketlist.model.ProductResponseModel;
import com.project.marketlist.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    List<ProductResponseModel> listList = new ArrayList<>();

    public List<ProductResponseModel> listaProvisoria (List<ProductResponseModel> lista){
        listList.clear();
        listList.addAll(lista);
        return listList;
    }

    public List<ProductModel> listAllProducts(){
        return productRepository.findAll();
    }

    public List<ProductModel> listAllProductsByCategory(Integer categoryId){
        return productRepository.findAllByCategoryId(categoryId);
    }

    //---------------------------------------------------------------------------------------


    public void generatePDF(){
        Document document = new Document(PageSize.A4);
        document.setMargins(40f, 40f, 40f, 40f);

        try {

            PdfWriter.getInstance(document, new FileOutputStream("lista-mercado.pdf"));
            document.open();
            Date date = new Date();
            DateFormat formatator = DateFormat.getDateInstance(DateFormat.FULL);

            Image image = Image.getInstance("C:/ws_projetos/projeto-market-list/backend/images/logo.jpg");
            image.scaleAbsolute(50f, 50f);
            image.setAlignment(Element.ALIGN_CENTER);

            Paragraph linhaEmBranco = new Paragraph(new Phrase(20F, "                      ", FontFactory.getFont(FontFactory.TIMES_BOLD, 16F)));
            linhaEmBranco.setAlignment(Element.ALIGN_CENTER);

            Paragraph dateToday = new Paragraph(formatator.format(date), FontFactory.getFont(FontFactory.TIMES, 12F));
            dateToday.setAlignment(Element.ALIGN_CENTER);

            Paragraph title = new Paragraph("Lista de Mercado", FontFactory.getFont(FontFactory.TIMES_BOLD, 16F));
            title.setAlignment(Element.ALIGN_CENTER);



            //------------------------------------------------------------------------------------------


            PdfPTable tableMain = new PdfPTable(2);
            //tableMain.setBorder(1);
            //tableMain.setBorderWidth(1);


            PdfPTable tableTest = new PdfPTable(3);
            tableTest.setWidthPercentage(100f);
            tableTest.setWidths(new float[]{55f, 30f, 15f});

            PdfPTable tableTest2 = new PdfPTable(3);
            tableTest2.setWidthPercentage(100f);
            tableTest2.setWidths(new float[]{55f, 30f, 15f});

            PdfPTable tableTest3 = new PdfPTable(3);
            tableTest3.setWidthPercentage(100f);
            tableTest3.setWidths(new float[]{55f, 30f, 15f});

            PdfPTable tableTest4 = new PdfPTable(3);
            tableTest4.setWidthPercentage(100f);
            tableTest4.setWidths(new float[]{55f, 30f, 15f});

            PdfPTable tableTest5 = new PdfPTable(3);
            tableTest5.setWidthPercentage(100f);
            tableTest5.setWidths(new float[]{55f, 30f, 15f});

            PdfPTable tableHeader = new PdfPTable(3);
            tableHeader.setWidthPercentage(100f);
            tableHeader.setWidths(new float[]{55f, 30f, 15f});


            PdfPCell tableCell = new PdfPCell(tableTest);
            PdfPCell tableCell2 = new PdfPCell(tableTest2);
            PdfPCell tableCell3 = new PdfPCell(tableTest3);
            PdfPCell tableCell4 = new PdfPCell(tableTest4);
            PdfPCell tableCell5 = new PdfPCell(tableTest5);
            PdfPCell tableCellHeader = new PdfPCell(tableHeader);


            PdfPCell product = new PdfPCell( new Paragraph(12, "Produto", FontFactory.getFont(FontFactory.TIMES, 12)));
            product.setPaddingBottom(5.0f);
            product.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPCell quantity = new PdfPCell( new Paragraph(12, "Quantidade", FontFactory.getFont(FontFactory.TIMES, 12)));
            quantity.setPaddingBottom(5.0f);
            quantity.setHorizontalAlignment(Element.ALIGN_CENTER);

            Image check = Image.getInstance("C:/ws_projetos/projeto-market-list/backend/images/check.jpg");
            check.scaleAbsolute(15,15);
            check.setAlignment(Element.ALIGN_CENTER);
            PdfPCell cellImg = new PdfPCell(check);
            cellImg.setBorder(PdfPCell.NO_BORDER);
            cellImg.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellImg.setPaddingTop(2.7f);

            //-----------------------------------------------------------------------------------

            tableHeader.addCell(product);
            tableHeader.addCell(quantity);
            tableHeader.addCell(cellImg);

            PdfPCell productName = new PdfPCell();

            PdfPCell productQuantity = new PdfPCell();

            PdfPCell productOk = new PdfPCell();

            /*for(ProductResponseModel data : listList){
                 productName = new PdfPCell(new Phrase(data.getProductName()));
                 productName.setHorizontalAlignment(Element.ALIGN_CENTER);
                 productQuantity = new PdfPCell(new Phrase (String.valueOf(data.getProductQtd())));
                 productQuantity.setHorizontalAlignment(Element.ALIGN_CENTER);
                 productOk = new PdfPCell(new Phrase(" "));
                 tableTest.addCell(productName);
                 tableTest.addCell(productQuantity);
                 tableTest.addCell(productOk);
            }*/

            int cont = 0;

            for(int i = 0; i < listList.size(); i++){
                if (cont < 37) {
                    productName = new PdfPCell(new Phrase(listList.get(i).getProductName()));
                    productName.setHorizontalAlignment(Element.ALIGN_CENTER);
                    productQuantity = new PdfPCell(new Phrase(String.valueOf(listList.get(i).getProductQtd())));
                    productQuantity.setHorizontalAlignment(Element.ALIGN_CENTER);
                    productOk = new PdfPCell(new Phrase("  "));
                    tableTest.addCell(productName);
                    tableTest.addCell(productQuantity);
                    tableTest.addCell(productOk);
                }
                cont ++;
                if (cont >= 38 && cont < 75){
                    productName = new PdfPCell(new Phrase(listList.get(i).getProductName()));
                    productName.setHorizontalAlignment(Element.ALIGN_CENTER);
                    productQuantity = new PdfPCell(new Phrase(String.valueOf(listList.get(i).getProductQtd())));
                    productQuantity.setHorizontalAlignment(Element.ALIGN_CENTER);
                    productOk = new PdfPCell(new Phrase("  "));
                    tableTest2.addCell(productName);
                    tableTest2.addCell(productQuantity);
                    tableTest2.addCell(productOk);
                }
                if (cont >= 75 && cont < 118){
                    productName = new PdfPCell(new Phrase(listList.get(i).getProductName()));
                    productName.setHorizontalAlignment(Element.ALIGN_CENTER);
                    productQuantity = new PdfPCell(new Phrase(String.valueOf(listList.get(i).getProductQtd())));
                    productQuantity.setHorizontalAlignment(Element.ALIGN_CENTER);
                    productOk = new PdfPCell(new Phrase("  "));
                    tableTest3.addCell(productName);
                    tableTest3.addCell(productQuantity);
                    tableTest3.addCell(productOk);
                }
                if(cont >= 118 && cont < 160){
                    productName = new PdfPCell(new Phrase(listList.get(i).getProductName()));
                    productName.setHorizontalAlignment(Element.ALIGN_CENTER);
                    productQuantity = new PdfPCell(new Phrase(String.valueOf(listList.get(i).getProductQtd())));
                    productQuantity.setHorizontalAlignment(Element.ALIGN_CENTER);
                    productOk = new PdfPCell(new Phrase("  "));
                    tableTest4.addCell(productName);
                    tableTest4.addCell(productQuantity);
                    tableTest4.addCell(productOk);
                }
                if(cont >= 160){
                        productName = new PdfPCell(new Phrase(listList.get(i).getProductName()));
                        productName.setHorizontalAlignment(Element.ALIGN_CENTER);
                        productQuantity = new PdfPCell(new Phrase(String.valueOf(listList.get(i).getProductQtd())));
                        productQuantity.setHorizontalAlignment(Element.ALIGN_CENTER);
                        productOk = new PdfPCell(new Phrase("  "));
                        tableTest5.addCell(productName);
                        tableTest5.addCell(productQuantity);
                        tableTest5.addCell(productOk);
                    }
                }

                listList.clear();

                tableMain.addCell(tableCellHeader);
                tableMain.addCell(tableCellHeader);
                tableMain.addCell(tableCell);
                tableMain.addCell(tableCell2);
                tableMain.addCell(tableCell3);
                tableMain.addCell(tableCell4);
                tableMain.addCell(tableCell5);
                tableMain.addCell(" ");

            //----------------------------------------------------------------------------------------------



            document.add(image);
            document.add(dateToday);
            document.add(linhaEmBranco);
            document.add(title);
            document.add(linhaEmBranco);
            document.add(tableMain);

            Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "lista-mercado.pdf"});

            document.close();

        } catch (FileNotFoundException e){
            System.out.println(e);
        } catch (DocumentException e){
            System.out.println(e);
        } catch (IOException e){
            System.out.println(e);
        }

    }

    }




