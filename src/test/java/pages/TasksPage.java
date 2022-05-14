package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TasksPage extends BasePage {
	@FindBy(css="#task")
	private WebElement taskField;
	@FindBy(css="#newtask_submit")
	private WebElement taskBtn;
	@FindBy(css="#newtask_adv>span")
	private WebElement advTaskBtn;
	@FindBy(css="#search")
	private WebElement searchField;
	@FindBy(css = ".mtt-tabs-add-button>span")
	private WebElement addListBtn;
	@FindBy(css="#total")
	private WebElement totalLabel;
	@FindBy(css = "li>a>span")
	private List<WebElement> list;
	//menu
	@FindBy(css="#cmenu_delete")
	private WebElement menuDelete;
	public TasksPage(WebDriver driver) {
		super(driver);
	}

	
	public void addSimpleTask(String name) {
		fillText(taskField, name);
		click(taskBtn);
		sleep(1000);
	}

	public void openAdvTask() {
		click(advTaskBtn);
	}

	public void search(String name) {
		fillText(searchField, name);
		sleep(2000);
	}
	
	public void addList(String name) {				
		click(addListBtn);
		alertOK(name);
		sleep(1000);
	}

	public void chooseList(String name) {
		//List<WebElement> list = driver.findElements(By.cssSelector("li>a>span"));
		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(name)) {
				click(el);
				break;
			}

		}
	}
	
	
	//validation
	public int getNumTasks() {
		String s= getText(totalLabel);
		int num= Integer.parseInt(s);
		return num;
	}
	
	
	public boolean isTaskExist(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector("#tasklist>li"));
		for (WebElement el : list) {
			if (getText(el).equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isListExist(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector("li>a>span"));
		for (WebElement el : list) {
			if (getText(el).equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void deleteTask(String taskName) {
		List<WebElement> taskList = driver.findElements(By.cssSelector("#tasklist>li"));
		for (int i = 0; i < taskList.size(); i++) {
			if (getText(taskList.get(i)).equalsIgnoreCase(taskName)) {
				// mouse hover
				moveTo(taskList.get(i));
				sleep(2000);
				// click on menu
				List<WebElement> menuList = driver.findElements(By.cssSelector(".taskactionbtn"));
				click(menuList.get(i));
				sleep(2000);
				// click on delete 
				click(menuDelete);
				// alert
				alertAccept();
				break;
			}
		}

	}

}
