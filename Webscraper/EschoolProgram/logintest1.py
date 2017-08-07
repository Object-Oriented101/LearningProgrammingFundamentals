import requests
from lxml import html


USERNAME = "P.sangamnerkar"
PASSWORD = "3M116TF8"

LOGIN_URL = "https://hacipe.sungardk12saas.com/HomeAccess/Account/LogOn?ReturnUrl=%2fHomeAccess"
URL = "https://hacipe.sungardk12saas.com/HomeAccess/Classes/Classwork"

def main():
    session_requests = requests.session()

    # Get login csrf token
    result = session_requests.get(LOGIN_URL)
    tree = html.fromstring(result.text)
    #authenticity_token = list(set(tree.xpath("//input[@name='csrfmiddlewaretoken']/@value")))[0]

    # Create payload
    payload = {
        "username": USERNAME,
        "password": PASSWORD,
     #   "csrfmiddlewaretoken": authenticity_token
    }

    # Perform login
    result = session_requests.post(LOGIN_URL, data = payload, headers = dict(referer = LOGIN_URL))


    # Scrape url
    result = session_requests.get(URL, headers = dict(referer = URL))
    tree = html.fromstring(result.content)
    #bucket_names = tree.xpath("//div[@class='repo-list--repo']/a/text()")
    bucket_names = tree.xpath("//a[@href='/HomeAccess/Account/LogOff']/a/text()")
    print(bucket_names)

if __name__ == '__main__':
    main()
