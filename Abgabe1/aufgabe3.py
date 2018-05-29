#Aufgabe 3 von Robin Schmidt, Max Verpers, Milena Stück Python variante
import sys
import numpy as np

def sqrCut(n):
    dim = np.sqrt(len(n))
    cut = dim/2
    a0=[]
    a1=[]
    a2=[]
    a3=[]
    a4=[]
    i = 0
    for element in n:
        if i%dim<cut and i/dim<cut: #a1 topLeft
            a1.append(element)
        elif i%dim>=cut and i/dim<cut: #a2 topRight
            a2.append(element)
        elif i%dim<cut and i/dim>= cut: #3 botLeft
            a3.append(element)
        elif i%dim>=cut and i/dim>=cut: #4 botRight
            a4.append(element)
        i+=1

    a0.append(Matrix(a1))
    a0.append(Matrix(a2))
    a0.append(Matrix(a3))
    a0.append(Matrix(a4))

    return a0

def mergeMatrices(newLayout):
    mergedMatrix = []
    Ma = newLayout[0]
    MaI = 0
    Mb = newLayout[1]
    MbI = 0
    Mc = newLayout[2]
    McI = 0
    Md = newLayout[3]
    MdI = 0
    dim = np.sqrt(len(Ma.matrix))
    totalSize = dim*dim*4
    for i in range(0,(int)(totalSize)):
        if i%(dim*2)<dim and i/(dim*2)<dim: #a1 topLeft
            mergedMatrix.append(Ma.matrix[MaI])
            MaI += 1
        elif i%(dim*2)>=dim and i/(dim*2)<dim: #a2 topRight
            mergedMatrix.append(Mb.matrix[MbI])
            MbI += 1
        elif i%(dim*2)<dim and i/(dim*2)>=dim: #3 botLeft
            mergedMatrix.append(Mc.matrix[McI])
            McI += 1
        elif i%(dim*2)>=dim and i/(dim*2)>=dim: #4 botRight
            mergedMatrix.append(Md.matrix[MdI])
            MdI += 1
    
    #print(mergedMatrix)
    return Matrix(mergedMatrix)
    


def createMatrix(n):
    x = 0
    y = 0
    i = 0
    dim = (int)(np.sqrt(len(n)))
    
    result = []
    while x < dim:
        line = []
        y= 0
        while y < dim:
           line.append((float)(n[i])) 
           i+=1
           y+=1
        x+=1
        #print(line)
        result.append(line)
    return result


class Matrix():
    """an matrix class with std matrix functions"""
    def __init__(self,a):
        if type(a) == Matrix:
            self.matrix = Matrix
        else:
            self.matrix=[]
            i =0
            for element in a:
                #print(element)
                self.matrix.append((float)(element))

    def __add__(self,other):
        i= 0
        newMatrix = []
        for element in self.matrix:
            value =self.matrix[i] + other.matrix[i]
            #print(value)
            newMatrix.append(value)
            
            i += 1
        #print(newMatrix)  
        return Matrix(newMatrix)

    def __repr__(self):
        return (str)(createMatrix(self.matrix))
    
    def __sub__(self,other):
        i= 0
        newMatrix = []
        for element in self.matrix:
            value =self.matrix[i] - other.matrix[i]
            #print(value)
            newMatrix.append(value)
            
            i += 1
        #print(newMatrix)  
        return Matrix(newMatrix)

    def __mul__(self,other):
        n = self.matrix
        k = other.matrix
        dim = np.sqrt(len(n))
        #print("self Matrix: ",self.matrix)
        #print("other Matrix: ",other.matrix)
        
        if dim <= 2:
            print("if",dim)
            a1 = n[2]+n[3]-n[1]
            a2 = n[0]+n[1]-n[2]-n[3]
            a3 = -n[2]
            a4 = n[3]
            b1 = k[0]+k[1]-k[2]
            b2 = -k[0]-k[1]+k[2]+k[3]
            b3 = -k[1]
            b4 = k[2]        
        else:
            #print("else",dim)
            cuttedA = sqrCut(n)
            a1 = cuttedA[0]
            #print("\nA1: ",a1)
            a2 = cuttedA[1]
            a3 = cuttedA[2]
            a4 = cuttedA[3]
            cuttedB = sqrCut(k) 
            b1 =cuttedB[0]
            b2 =cuttedB[1]
            b3 =cuttedB[2]
            b4 =cuttedB[3]

        p1 = a1*b1
        p2 = a2*(b1+b4)
        p3 = a3*(b1+b3)
        p4 = a4*(b1+b2)
        p5 = b2*(a1+a3)
        p6 = b3*(a1+a2)
        p7 = b4*(a1+a4)

        result =[p1+p2+p6+p7,p4-p6,p7-p3,p1+p3+p4+p5]
        if dim > 2:
            result=mergeMatrices(result)
        else:
            result=Matrix(result)
            #print(result)
        return result 

        

if __name__ == "__main__":
    matrixA = open("A.dat","r").readline().split(" ")
    matrixA = Matrix(matrixA)
    matrixB = open("B.dat","r").readline().split(" ")
    matrixB = Matrix(matrixB)

    matrixC = matrixA*matrixB

    print("matrixA: ",matrixA,"\nmatrixB: ",matrixB,"\nmatrixC: ",matrixC)
        