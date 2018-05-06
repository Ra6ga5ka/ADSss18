#Aufgabe 2 von Robin Schmidt, Max Verpers, Milena Stück Python variante
import sys



    
def bicoef1(n,k):   
    if k==0 or k==n:
        return 1
    if k>n:
        return 0
    return bicoef1(n-1,k-1)+bicoef1(n-1,k)

def bicoef2(n,k):   
    if k==0 or k==n:
        return 1
    if k>n:
        return 0
    return (int)(bicoef2(n-1,k-1)*(n/k)) #cast this to an int so that this is still usess the right alorythm 

if __name__ == "__main__":
    #check parameters
    print("\n")
    if len(sys.argv) is 3:
       
        print("bicoef1(",sys.argv[1],",",sys.argv[2],")=",bicoef1((int)(sys.argv[1]),(int)(sys.argv[2])),"\n")
        print("bicoef2(",sys.argv[1],",",sys.argv[2],")=",bicoef2((int)(sys.argv[1]),(int)(sys.argv[2])),"\n")
    else:
        print("wrong number of arguments\n")
        