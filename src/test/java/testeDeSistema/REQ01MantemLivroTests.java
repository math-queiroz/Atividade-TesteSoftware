package testeDeSistema;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ01MantemLivroTests {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ts-scel-web.herokuapp.com/login");
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	/*
	 * 1)Com base nos requisitos de usuário do Sistema de Controle de Empréstimo e
	 * Devolução de Livros, capture os scripts de teste para a função mantem livro
	 * (cadastrar, consultar, alterar e excluir), utilizando a técnica de
	 * caixa-preta, critério classes de equivalência, somente para as classes
	 * válidas. Publique o script no GitHub e compartilhe o endereço no relatório de
	 * teste. Mantém Livros - REQ01. O sistema deve permitir o cadastro, consulta,
	 * edição para alteração e exclusão de livros. O sistema deve rejeitar entradas
	 * inválidas – entrada válida para ISBN no mínimo 4 e no máximo 4 caracteres,
	 * não deve permitir o cadastro de um ISBN já cadastrado, entrada válida para
	 * autor e título entre 1 e 50 caracteres.
	 */

	
	@Test
	public void cadastrarlivro() {
		driver.get("https://ts-scel-web.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(600, 600));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		espera();

		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("John Doe");
		driver.findElement(By.id("titulo")).sendKeys("Javascript - Curso Completo");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();

		driver.findElement(By.cssSelector("td:nth-child(2)")).click();

		assertTrue(driver.getPageSource().contains("1234"));
		assertTrue(driver.getPageSource().contains("John Doe"));

		driver.findElement(By.linkText("Excluir")).click();
	}
	
	
	/*
	 * 2) Elabore um relatório de teste para descrever eventuais incidentes de
	 * teste, falhas detectadas no software sob teste ou dificuldades na ferramenta
	 * de teste para implementar o script automatizado.
	 */
	@Test
	public void cadastrarlivroAutorNulo() {
		driver.get("https://ts-scel-web.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(600, 600));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		espera();

		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("");
		driver.findElement(By.id("titulo")).sendKeys("John Doe");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	}

	/*
	 * 2) Elabore um relatório de teste para descrever eventuais incidentes de
	 * teste, falhas detectadas no software sob teste ou dificuldades na ferramenta
	 * de teste para implementar o script automatizado.
	 */
	@Test
	public void cadastrarlivroAutorForaDoLimiteDeCaracters() {
		driver.get("https://ts-scel-web.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(600, 600));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		espera();

		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor"))
				.sendKeys("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
						+ "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
						+ "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		driver.findElement(By.id("titulo")).sendKeys("1984");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	}

	/*
	 * 2) Elabore um relatório de teste para descrever eventuais incidentes de
	 * teste, falhas detectadas no software sob teste ou dificuldades na ferramenta
	 * de teste para implementar o script automatizado.
	 */
	@Test
	public void cadastrarlivroTituloNulo() {
		driver.get("https://ts-scel-web.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(600, 600));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		espera();

		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("John Doe");
		driver.findElement(By.id("titulo")).sendKeys("");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();

	}

	/*
	 * 2) Elabore um relatório de teste para descrever eventuais incidentes de
	 * teste, falhas detectadas no software sob teste ou dificuldades na ferramenta
	 * de teste para implementar o script automatizado.
	 */
	@Test
	public void cadastrarlivroTituloForaDoLimiteDeCaracteres() {
		driver.get("https://ts-scel-web.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(600, 600));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		espera();

		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("John Doe");
		driver.findElement(By.id("titulo"))
				.sendKeys("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
						+ "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\"\r\n"
						+ "				+ \"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
						+ "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
						+ "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\"\r\n"
						+ "				+ \"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();

	}

	/*
	 * 2) Elabore um relatório de teste para descrever eventuais incidentes de
	 * teste, falhas detectadas no software sob teste ou dificuldades na ferramenta
	 * de teste para implementar o script automatizado.
	 */
	@Test
	public void cadastrarlivroISBNNulo() {
		driver.get("https://ts-scel-web.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(600, 600));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		espera();

		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("John Doe");
		driver.findElement(By.id("titulo")).sendKeys("1984");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();

	}

	/*
	 * 2) Elabore um relatório de teste para descrever eventuais incidentes de
	 * teste, falhas detectadas no software sob teste ou dificuldades na ferramenta
	 * de teste para implementar o script automatizado.
	 */
	@Test
	public void cadastrarlivroISBNForaDoLimiteDeCaracteres() {
		driver.get("https://ts-scel-web.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(600, 600));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		espera();

		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("11111");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("John Doe");
		driver.findElement(By.id("titulo")).sendKeys("O pequeno príncipe");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();

	}

	/*
	 * 1)Com base nos requisitos de usuário do Sistema de Controle de Empréstimo e
	 * Devolução de Livros, capture os scripts de teste para a função mantem livro
	 * (cadastrar, consultar, alterar e excluir), utilizando a técnica de
	 * caixa-preta, critério classes de equivalência, somente para as classes
	 * válidas. Publique o script no GitHub e compartilhe o endereço no relatório de
	 * teste. Mantém Livros - REQ01. O sistema deve permitir o cadastro, consulta,
	 * edição para alteração e exclusão de livros. O sistema deve rejeitar entradas
	 * inválidas – entrada válida para ISBN no mínimo 4 e no máximo 4 caracteres,
	 * não deve permitir o cadastro de um ISBN já cadastrado, entrada válida para
	 * autor e título entre 1 e 50 caracteres.
	 */
	@Test
	public void consultarLivro() {
		driver.get("https://ts-scel-web.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(600, 600));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.linkText("Lista de Livros")).click();
		driver.findElement(By.cssSelector("td:nth-child(2)")).click();
	}

	/*
	 * 2) Elabore um relatório de teste para descrever eventuais incidentes de
	 * teste, falhas detectadas no software sob teste ou dificuldades na ferramenta
	 * de teste para implementar o script automatizado.
	 */
	@Test
	public void consultarLivroISBNInvalido() {
		driver.get("https://ts-scel-web.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(945, 1020));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.linkText("Lista de Livros")).click();
		driver.findElement(By.cssSelector("td:nth-child(2)")).click();
	}

	/*
	 * 1)Com base nos requisitos de usuário do Sistema de Controle de Empréstimo e
	 * Devolução de Livros, capture os scripts de teste para a função mantem livro
	 * (cadastrar, consultar, alterar e excluir), utilizando a técnica de
	 * caixa-preta, critério classes de equivalência, somente para as classes
	 * válidas. Publique o script no GitHub e compartilhe o endereço no relatório de
	 * teste. Mantém Livros - REQ01. O sistema deve permitir o cadastro, consulta,
	 * edição para alteração e exclusão de livros. O sistema deve rejeitar entradas
	 * inválidas – entrada válida para ISBN no mínimo 4 e no máximo 4 caracteres,
	 * não deve permitir o cadastro de um ISBN já cadastrado, entrada válida para
	 * autor e título entre 1 e 50 caracteres.
	 */
	@Test
	public void atualizarLivro() {
		try {
			driver.get("https://ts-scel-web.herokuapp.com/login");
			driver.manage().window().setSize(new Dimension(945, 1020));
			driver.findElement(By.name("username")).click();
			driver.findElement(By.name("username")).sendKeys("jose");
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.cssSelector("button")).click();
			driver.findElement(By.linkText("Livros")).click();
			driver.findElement(By.id("isbn")).click();
			driver.findElement(By.id("isbn")).sendKeys("1236");
			driver.findElement(By.cssSelector(".row:nth-child(3) > .form-group")).click();
			driver.findElement(By.id("autor")).click();
			driver.findElement(By.id("autor")).sendKeys("John Doe");
			driver.findElement(By.id("titulo")).click();
			driver.findElement(By.id("titulo")).sendKeys("TESTE");
			driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
			driver.findElement(By.cssSelector("tr:nth-child(2) .btn-primary")).click();
			driver.findElement(By.id("titulo")).click();
			driver.findElement(By.id("titulo")).sendKeys("TESTE 2");
			driver.findElement(By.cssSelector(".btn")).click();
			driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(3)")).click();
			driver.findElement(By.cssSelector("tr:nth-child(2) .delete")).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String waitForWindow(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> whNow = driver.getWindowHandles();
		Set<String> whThen = (Set<String>) vars.get("window_handles");
		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}
}
