from urllib2 import urlopen as uReq
from bs4 import BeautifulSoup as soup

import numpy as np
import pandas as  pd
from pandas import Series, DataFrame


my_url = 'http://www.bestbuy.com/site/searchpage.jsp?st=laptops&_dyncharset=UTF-8&id=pcat17071&type=page&sc=Global&cp=1&nrp=&sp=&qp=&list=n&af=true&iht=y&usc=All+Categories&ks=960&keys=keys'

uClient = uReq(my_url)
page_html = uClient.read()
uClient.close()
page_soup = soup(page_html, "html.parser")
containers = page_soup.find_all("div",{'class':'list-item'})

print len(containers)

DF_obj = DataFrame(columns = ['Name', 'Price'])

for index,container in enumerate(containers):
   try:
      title_container = container.find_all("h4")
      price_container = container.find_all("div", {"class", "pb-hero-price pb-purchase-price"})
      DF_obj.loc[index,'Name'] = title_container[0].text
      DF_obj.loc[index, 'Price'] = price_container[0].text
   except Exception:
       pass
print DF_obj