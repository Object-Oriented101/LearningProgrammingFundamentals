from selenium import webdriver
from selenium.webdriver.common.keys import Keys

br = webdriver.Chrome('/home/reality/Downloads/chromedriver');
br.get('https://hacipe.sungardk12saas.com/HomeAccess/Account/LogOn?ReturnUrl=%2fHomeAccess')

username = br.find_element_by_id('LogOnDetails_UserName')
username.send_keys('P.sangamnerkar')
password = br.find_elements_by_id('LogOnDetails_Password')
password[0].send_keys('3M116TF8')
inputElement = webdriver.find_button();
inputElement.click()

#password[0].sendKeys(Keys.ENTER);
#br.find_element_by_class_name('ui-button-text').send_keys(Keys.ENTER)
