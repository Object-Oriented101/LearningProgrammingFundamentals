from urllib2 import urlopen as uReq
from bs4 import BeautifulSoup as soup


my_url = 'https://www.newegg.com/Video-Cards-Video-Devices/Category/ID-38?Tpk=graphics%20cards'

#opens connection by grabbing the page
uClient = uReq(my_url)
page_html = uClient.read()
uClient.close()

#html parser
page_soup = soup(page_html, "html.parser")
#grabs each product
containers = page_soup.find_all("div",{"class":"item-container"})

filename = "products.ods"
f = open(filename,"w")

headers = "product_name, shipping\n"

f.write(headers)
for container in containers:

   # brand_container = container.find_all("a", {"class":"item-brand"})
    #brand = container.div.div.a.img["title"]


    title_container = container.find_all("a", {"class": "item-title"})
    product_name = title_container[0].text

    shipping_container = container.find_all("li", {"class": "price-ship"})
    shipping = shipping_container[0].text.strip()

    #print("brand: "+ brand)
    print("product_name: "+ product_name)
    print("shipping: "+ shipping)

    f.write(product_name.replace(",","|") + "," + shipping +"\n");

f.close()