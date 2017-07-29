from urllib2 import urlopen as uReq
from bs4 import BeautifulSoup as soup


my_url = 'https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=books'

#opens connection by grabbing the page
uClient = uReq(my_url)
page_html = uClient.read()
uClient.close()

#html parser
page_soup = soup(page_html, "html.parser")
#grabs each product
containers = page_soup.find_all("div",{"class":"s-item-container"})

filename = "products.ods"
f = open(filename,"w")
headers = "product_name, shipping\n"
f.write(headers)

for container in containers:

   # brand_container = container.find_all("a", {"class":"item-brand"})
    #brand = container.div.div.a.img["title"]
   try:
    # the h2 can be replaced with anything to match the tags name....same with the class, can change to be id
      title_container = container.find_all("h2", {"class": "a-size-medium s-inline s-access-title a-text-normal"})
      product_name = title_container[0].text

      price_container = container.find_all("span", {"class": "sx-price-whole"})
      product_price = price_container[0].text
      #print("brand: "+ brand)
      print("Product Name: "+ product_name)
      print("Price: $"+ product_price)
   except Exception:
       pass

