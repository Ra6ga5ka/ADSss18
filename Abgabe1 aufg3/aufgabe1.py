#Aufgabe 1 von Robin Schmidt, Max Verpers, Milena Stück Python variante
import sys

def multiply(x,y):
    result = 0
    z = y
    while(x>0):
        if x%2 !=0:
            result+=z
        x=(int)(x/2)
        z=z*2
        
    return (result)

if __name__ == "__main__":
    #check parameters
    print("\n")
    if len(sys.argv) is 3:
       
        print(sys.argv[1],"x",sys.argv[2],"=",multiply((int)(sys.argv[1]),(int)(sys.argv[2])),"\n")
    else:
        print("wrong number of arguments\n")
    
    print("Die Anzahl der Schleifendurchläufe beträgt Log(1.Zahl) zur basis 2 \n")
    print("Die ~neue~ variante benötigt mehrere iterationen, die einzelnen Operationen sind aber wesentlich simpler.\nDer in der Schule gelerne algorythmus ist Log(1.Zahl) zur basis 10 die hier implementiere algorythmus zur basis 2")
    print("somit ist die Komplexität des algorytmus wesentlich höher aus von dem in der schule gelernten\n")
        