from urllib2 import urlopen as uReq
from bs4 import BeautifulSoup as soup


my_url = 'http://www.bestbuy.com/site/searchpage.jsp?st=laptops&_dyncharset=UTF-8&id=pcat17071&type=page&sc=Global&cp=1&nrp=&sp=&qp=&list=n&af=true&iht=y&usc=All+Categories&ks=960&keys=keys'

#opens connection by grabbing the page
uClient = uReq(my_url)
page_html = uClient.read()
uClient.close()

#html parser
page_soup = soup(page_html, "html.parser")
#grabs each product
containers = page_soup.find_all("div",{"class":"row"})

filename = "products.ods"
f = open(filename,"w")
headers = "product_name, shipping\n"
f.write(headers)

for container in containers:

   # brand_container = container.find_all("a", {"class":"item-brand"})
    #brand = container.div.div.a.img["title"]
   try:
    # the h2 can be replaced with anything to match the tags name....same with the class, can change to be id
      title_container = container.find_all("h4")
      product_name = title_container[0].text #if the text is inside the tag(meaning inside the open and close brackers), need to add index 0

      price_container = container.find_all("div", {"class", "pb-hero-price pb-purchase-price"})
      product_price = price_container[0].text
      #print("brand: "+ brand)
      print("Product Name: "+ product_name)
      print("Price:"+ product_price)
      f.write(product_name + ","+product_price+"\n")


   except Exception:
       pass
f.close()
