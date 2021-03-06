package kornell.gui.client.presentation.welcome.generic;


import java.math.BigDecimal;

import kornell.core.shared.data.Course;
import kornell.core.shared.data.CourseTO;
import kornell.gui.client.presentation.atividade.AtividadePlace;

import com.github.gwtbootstrap.client.ui.Heading;
import com.github.gwtbootstrap.client.ui.Image;
import com.github.gwtbootstrap.client.ui.Paragraph;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GenericCourseSummaryView extends Composite {
	interface MyUiBinder extends UiBinder<Widget, GenericCourseSummaryView> {
	}

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	@UiField
	Heading hTitle;
	
	@UiField
	Paragraph pDescription;
	
	@UiField
	Paragraph pProgress;
	
	@UiField
	Image imgThumb;

	public GenericCourseSummaryView(final PlaceController placeCtrl, final CourseTO courseTO) {
		initWidget(uiBinder.createAndBindUi(this));
		
		final Course course = courseTO.getCourse();
		hTitle.setText(course.getTitle());
		pDescription.setText(course.getDescription());
		
		BigDecimal progress = courseTO.getEnrollment().getProgress();
		if(progress != null){
			if(progress.compareTo(BigDecimal.ONE) == 0)
				//TODO: i18n
				pProgress.setText("Course complete.");
			else
				pProgress.setText(toPercentString(progress));
		}else{
			//TODO: i18n
			pProgress.setText("Not started yet.");
		}
		
		String assetsURL = course.getAssetsURL();
		imgThumb.setUrl(assetsURL + "thumb.jpg");
		imgThumb.setHeight("240");
		imgThumb.setHeight("135");
		
		sinkEvents(Event.ONCLICK);
		addHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				placeCtrl.goTo(new AtividadePlace(course.getUUID(), 0));
			}
		}, ClickEvent.getType());
		
	}

	private String toPercentString(BigDecimal progress) {
		return progress.multiply(new BigDecimal("100")).toPlainString() + " %";		
	}



}
