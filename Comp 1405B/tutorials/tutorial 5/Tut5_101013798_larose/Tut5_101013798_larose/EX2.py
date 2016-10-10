from SimpleGraphics import *
img = loadImage(input("What is the file name: "))
drawImage(img, 400-(getWidth(img)), 300-(getHeight(img)/2))
img2 = createImage(getWidth(img), getHeight(img))

for x in range(0, getWidth(img)):
    for y in range(0, getHeight(img)):
        r, g, b = getPixel(img, x, y)
        putPixel(img2, x, y, 255-r, 255-g, 255-b)

drawImage(img2, 400, 300-(getHeight(img)/2))