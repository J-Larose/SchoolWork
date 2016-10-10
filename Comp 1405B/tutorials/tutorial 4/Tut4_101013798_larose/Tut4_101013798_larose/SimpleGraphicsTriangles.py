import SimpleGraphics
import math
# Draw a scalene triangle (i.e., sides of different lengths) that connects
# the three points that are passed to this function as arguments
# @param x1 the x co-ordinate of the first point
# @param y1 the y co-ordinate of the first point
# @param x2 the x co-ordinate of the second point
# @param y2 the y co-ordinate of the second point
# @param x3 the x co-ordinate of the third point
# @param y3 the y co-ordinate of the third point
def scalene(x1, y1, x2, y2, x3, y3):
    SimpleGraphics.poly(x1, y1, x2, y2, x3, y3)
# Draw an isoceles (i.e., two sides the same length) triangle with the base
# centered at the point provided in the first two arguments, using the
# specified base and height
# @param x the x co-ordinate for the center of the base
# @param y the y co-ordinate for the center of the base
# @param b the length of the base of the triangle
# @param h the height of the triangle
def isoceles(x, y, b, h):
    SimpleGraphics.poly(x, y+h, x+(b/2), y, x-(b/2), y)
# Draw a right angled triangle for which the point opposite the hypotenuse
# is specified by the first two arguments, the length of the opposite and
# adjacent sides are specified by the third and fourth argument, and the
# fifth argument is a string indicating the direction the triangle is facing
# (i.e., "tr", "tl", "br", or "bl", for top-right, top-left, bottom-right,
# and bottom-left, respectively); this function returns True if the string is
# one of those four options, and False otherwise
# @param x the x co-ordinate of the point opposite the hypotenuse
# @param y the y co-ordinate of the point opposite the hypotenuse
# @param a the length of the adjacent side (height)
# @param o the length of the opposite side (width)
# @return Boolean value indicating whether or not the call was successful
def rightangled(x, y, a, o):
    SimpleGraphics.poly(x, y, x, y+a, y, x+o)
# Draw an equilateral triangle (i.e., all sides the same length) triangle
# that is centered at the point provided in the first two arguments, with
# the side length specified in the third argument
# @param x the x co-ordinate for the center of the triangle
# @param y the y co-ordinate for the center of the triangle
# @param s the length of sides of the triangle
def equilateral(x, y, s):
    SimpleGraphics.poly(x, y+((math.sqrt(math.pow(s,2)-math.pow(s/2,2)))/2), x-((math.sqrt(math.pow(s,2)-math.pow(s/2,2)))/2), y-((math.sqrt(math.pow(s,2)-math.pow(s/2,2)))/2), x+((math.sqrt(math.pow(s,2)-math.pow(s/2,2)))/2), y-((math.sqrt(math.pow(s,2)-math.pow(s/2,2)))/2))