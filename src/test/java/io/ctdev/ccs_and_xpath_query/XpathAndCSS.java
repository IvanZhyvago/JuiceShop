package io.ctdev.ccs_and_xpath_query;

public class XpathAndCSS {
    //console  -   $('#item-price')
    //div[contains(text(), 'Green Smoothie')]/../../../div/child::button
    //div[contains(text(), 'Green Smoothie')]/ancestor::mat-card/child::*/child::button
    //mat-grid-tile/child::figure/child::*/div/div/div[contains(text(), 'Green Smoothie')]
    //input [@id = 'emailControl']/ancestor::div[contains(@class,'mat-form-field')]//mat-error
    //By.xpath("//span[text() = 'contains at least one lower character']/../mat-icon")).getAttribute("aria-hidden")
    //*[contains(text(), 'Registration completed successfully. You can now log in.')]
    // ======Xpath======
    private String XpathProfileTitle = "//p[starts-with(@class,'ownUserProfile_title')]";
    // can't find path and svg //svg[contains(@xmlns,'www.w3.org')] ???
    //  -->  //*[name()='svg' and contains(@xmlns,'www.w3.org')]
    // CSS can -> svg[width*='105px']
    private String XpathCloseButton = "//button[contains(@class,'react-modal-close-btn')]";
    //don't work without contains ??? works - //button[@class = 'react-modal-close-btn']
    private String XpathUploadAnImage = "//p[contains(@class,'dropZoneHover__')]";
    // What is >Upload an image? Can we find it ? -> it's a text find with functions text()
    private String XpathName = "//p[text()='Name']";
    // can but not good idea //p[text()='Name'] need ask developer to add new id
    private String XpathNameInput = "//input[@name = 'name']";
    //   //input[@name = 'name' and contains(@value,'Ivan')]
    private String XpathButtonCancel = "//button[contains(@class,'cancelBtn')]";
    private String XpathButtonSaveChanges = "//button[@type = 'submit']";

    // ../ How it work?-> Parent /../ one layer up /../../ two layer up
    private String XpathJoinCall = "//div[contains(@class,'header')]/div/button[contains(@data-action,'join-group')]";


    // =====CSS====
    private String CSSProfileTitle = "[class^=ownUserProfile_title]";
    // [class^='ownUserProfile_title'] - works as previous 26 line

    // svg[viewBox*='0'] work
    // svg[viewBox*=0] don't work why ?
    private String CSSCloseButton = "[class*=react-modal-close-btn]";
    private String CSSUploadAnImage = "[class*=dropZoneHover__]";
    private String CSSName = "p:nth-child(1)[class*='1G5wu']"; // p should first child not a parent
    private String CSSNameInput = "input[name='name']";
    private String CSSButtonCancel = "button[class*='cancelBtn']";
    private String CSSButtonSaveChanges = "button[type='submit']";
    private String CSSJoinCall = "button:nth-child(1)[data-action*=join-group][class=callBtn_btn__1D_W0]";

}
