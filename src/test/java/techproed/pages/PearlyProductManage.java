package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.util.List;

public class PearlyProductManage {


    public PearlyProductManage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "product_type")
    public WebElement prodTypeList;

    @FindBy(id = "is_virtual")
    public WebElement virtualCheckBox;

    @FindBy(id = "is_downloadable")
    public WebElement downloadableCheckBox;

    @FindBy(id = "regular_price")
    public WebElement price;

    @FindBy(id = "sale_price")
    public WebElement salePrice;

    @FindBy(id = "featured_img_display")
    public WebElement picture1;

    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement picture2;

    @FindBy(id = "excerpt_ifr")
    public WebElement shortDescIframe;

    @FindBy(xpath = "//*[@data-id='excerpt']")
    public WebElement shortDescription;

    @FindBy(id = "description_ifr")
    public WebElement descriptionIframe;

    @FindBy(xpath = "//*[@data-id='description']")
    public WebElement description;

    @FindBy(xpath = "//*[@id='product_cats_checklist']//li")
    public List<WebElement> categoriesList;

    @FindBy(xpath = "//*[@id='product_brand']//li")
    public List<WebElement> brandList;

    @FindBy(id = "product_tags")
    public WebElement tags;

    @FindBy(id = "catalog_visibility")
    public WebElement catalogVisibility;

    @FindBy(id = "sku")
    public WebElement sku;

    @FindBy(xpath = "//*[@class='wcfm-tabWrap']")
    public WebElement inventoryTable;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[5]")
    public WebElement attributes;

    @FindBy(id = "attributes_is_active_1")
    public WebElement colorCheckBox;

    @FindBy(id = "attributes_is_active_2")
    public WebElement sizeCheckBox;
    @FindBy(id = "menu-item-browse")
    public WebElement mediaLibrary;

    @FindBy(xpath = "//li[@data-id='22586']")
    public WebElement macbookpro2;

    @FindBy(xpath = "(//div[@class='media-toolbar']//child::div[2])[2]")
    public WebElement selectButton;

    @FindBy(xpath = "//select[@id='attributes_value_1']")
    public WebElement selectText;

    @FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[2]//li//input")
    public WebElement colorInput;


    @FindBy(xpath = "(//div[@id='wcfm_products_manage_form_attribute_expander']//child::p)[17]//button")
    public WebElement addAttribute;

    @FindBy(xpath = "//div[@id='wcfm_products_simple_submit']//child::input[1]")
    public WebElement submitEnd;


}

