from SimpleGraphics import *
img = loadImage(input("What is the file name: "))
imgr = createImage(getWidth(img), getHeight(img))
imgg = createImage(getWidth(img), getHeight(img))
imgb = createImage(getWidth(img), getHeight(img))

for x in range(0, getWidth(img)):
    for y in range(0, getHeight(img)):
        r, g, b = getPixel(img, x, y)
        putPixel(imgr, x, y, r, 0, 0)
        putPixel(imgg, x, y, 0, g, 0)
        putPixel(imgb, x, y, 0, 0, b)

drawImage(img, 0, 0)
drawImage(imgr, getWidth(img), 0)
drawImage(imgg, getWidth(img)*2, 0)
drawImage(imgb, getWidth(img)*3, 0)