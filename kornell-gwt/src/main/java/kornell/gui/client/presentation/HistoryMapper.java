package kornell.gui.client.presentation;

import kornell.gui.client.presentation.atividade.AtividadePlace;
import kornell.gui.client.presentation.home.HomePlace;
import kornell.gui.client.presentation.vitrine.VitrinePlace;
import kornell.gui.client.presentation.welcome.WelcomePlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;


@WithTokenizers({HomePlace.Tokenizer.class,
	VitrinePlace.Tokenizer.class,
	WelcomePlace.Tokenizer.class,
	AtividadePlace.Tokenizer.class})
public interface HistoryMapper extends PlaceHistoryMapper {
}
