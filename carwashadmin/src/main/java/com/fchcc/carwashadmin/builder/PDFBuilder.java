package com.fchcc.carwashadmin.builder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fchcc.carwashadmin.model.Reserva;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFBuilder extends AbstractITextPdfView {
	@Override
	    protected void buildPdfDocument(Map<String, Object> model, Document doc,
	            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		 	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		 DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss"); 
	        // get data model which is passed by the Spring container
	        
		 	List<Reserva> list = (List<Reserva>) model.get("list");

	         
	        doc.add(new Paragraph("RESERVAS CARWASH"));
	         
	        PdfPTable table = new PdfPTable(4);
	        table.setWidthPercentage(100.0f);
	        table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f});
	        table.setSpacingBefore(10);
	         
	        // define font for table header row
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(BaseColor.WHITE);
	        // define table header cell
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(BaseColor.BLUE);
	        cell.setPadding(5);
	         
	        // write table header
	        cell.setPhrase(new Phrase("ID", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Servicio", font));
	        table.addCell(cell);
	 
	        cell.setPhrase(new Phrase("Fecha", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Hora", font));
	        table.addCell(cell);
	          
	         
	        // write table row data
	        for (Reserva rev: list) {
	            table.addCell(Integer.toString(rev.getId()));
	            table.addCell(rev.getServiceName());
	            table.addCell(dateFormat.format(rev.getFecha()));
	            table.addCell(timeFormat.format(rev.getHora()));
	            
	        }
	         
	        doc.add(table);
	         
	    }
}