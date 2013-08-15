package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ MainWindowContext.class, NavigationContext.class })
public class UIContext {

}
