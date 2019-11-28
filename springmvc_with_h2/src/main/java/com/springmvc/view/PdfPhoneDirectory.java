package com.springmvc.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.springmvc.model.Users;

public class PdfPhoneDirectory extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Users> usersList = (List<Users>) model.get("usersList");
		Table table = new Table(5);
		table.addCell("ID");
		table.addCell("First Name");
		table.addCell("Last Name");
		table.addCell("Phone Number");
		table.addCell("Phone Company");
		usersList.forEach(users -> {
			try {
				table.addCell(Integer.toString(users.getId()));
				table.addCell(users.getFirstName());
				table.addCell(users.getLastName());
				table.addCell(users.getPhoneNumber());
				table.addCell(users.getPhoneCompany());
			} catch (BadElementException e) {
				e.printStackTrace();
			}
		});
		document.add(table);
	}

}
