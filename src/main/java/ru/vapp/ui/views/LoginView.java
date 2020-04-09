package ru.vapp.ui.views;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Tag("sa-login-view")
@Route(value = LoginView.ROUTE)
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver  {
	public static final String ROUTE = "login";

	private LoginOverlay login = new LoginOverlay();
	H1 title = new H1();
    private Image image;
	
	public LoginView(){
		login.setI18n(createRussianI18n());
        
		title.getStyle().set("color", "var(--lumo-base-color)");
		image = new Image("/frontend/images/login-banner.jpg", "BannerImage");
		title.add(image);
		login.setAction("login");
        login.setTitle(title);  
//		login.setTitle("Тест приложение");
		login.setDescription("Вход в Тест приложение");
		login.setOpened(true);
		getElement().appendChild(login.getElement());
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		login.setError(event.getLocation().getQueryParameters().getParameters().containsKey("error"));
	}

    private LoginI18n createRussianI18n() {
        final LoginI18n i18n = LoginI18n.createDefault();
        
        i18n.setHeader(new LoginI18n.Header());
//        i18n.getHeader().setTitle("Титул 1");
//        i18n.getHeader().setDescription("Описание 2");
        i18n.getForm().setUsername("Пользователь");
        i18n.getForm().setTitle("Конфигуратор услуг");
        i18n.getForm().setSubmit("Вход");
        i18n.getForm().setPassword("Пароль");
        i18n.getForm().setForgotPassword("Забыли пароль");
        i18n.getErrorMessage().setTitle("Ошибка входа");
        i18n.getErrorMessage().setMessage("Ошиблись со входом.");
	i18n.setAdditionalInformation("ООО Асклепиус на платформе }> Vaadin");  
        
        return i18n;
	}
}
