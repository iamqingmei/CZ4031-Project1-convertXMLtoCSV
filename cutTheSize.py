# from xml.etree  import ElementTree
# parser = ElementTree.XMLParser()
# parser.parser.UseForeignDTD(True)
# parser.entity['&ouml'] = 'xxxx'

# tree = ElementTree.ElementTree()
# tree.parse('dblp.xml',parser=parser)

# dblp = tree.find('dblp')

# print("start book")
# books = dblp.findall('book')
# for i in range(len(books)/2):
#     dblp.remove(books[i])

# print("start article")
# articles = dblp.findall('article')
# for i in range(len(articles)/2):
#     dblp.remove(articles[i])

# print("start incollection")
# incollections = dblp.findall('incollection')
# for i in range(len(incollections)/2):
#     dblp.remove(incollections[i])

# print("start inproceedings")
# inproceedings = dblp.findall('inproceedings')
# for i in range(len(inproceedings)/2):
#     dblp.remove(inproceedings[i])

# print("start proceedings")
# proceedings = dblp.findall('proceedings')
# for i in range(len(proceedings)/2):
#     dblp.remove(proceedings[i])

# print("start phdthesis")
# phdthesis = dblp.findall('phdthesis')
# for i in range(len(phdthesis)/2):
#     dblp.remove(phdthesis[i])

# tree.write('half.xml')
f = open("half.xml","r")
lines = f.readlines()
f.close()
for i in range(len(lines)-6,len(lines)):
    print(lines[i]);
