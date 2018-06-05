

class Node:
    def __init__(self,next,obj,key):
        self.next = next
        #self.parent = parent
        self.obj = obj
        self.key = key

    def __repr__(self):
        return str(self.obj)

    def __str__(self):
        return str(self.obj)

    def __next__(self):
        return self.next

    


class prioQueue:
    def __init__(self):
        self.head=None
        self.len = 0
    
    def __add__(self, value,key):
        
        if self.head == None:
            self.head = Node(None,value,key)
        elif self.head.key > key:
            newNode=Node(self.head,value,key)
            self.head = newNode
        else:
            currentPos = self.head
            while True:
                if currentPos.next == None or currentPos.next.key>key:
                    newNode = Node(currentPos.next,value,key)
                    currentPos.next = newNode
                    break
                else:
                    currentPos=currentPos.next
        self.len = self.len+1

    def __len__(self):
        return self.len

    def __iter__(self):
        self.IterPos = self.head
        return self
    
    def __next__(self):
        self.IterPos =self.IterPos.next
        if self.IterPos is None:
            raise StopIteration  # signals "the end"
        return self.IterPos

    def __str__(self):
        line = ""
        for obj in self:
            line = line+" "+ str(obj)

        return line

    def insert(self, obj,prio):
        """ komplexity O(N)"""
        __add__(obj,prio)
    
    def min(self):
        """ komplexity O(1)"""
        return self.head

    def getMin(self):
        """ komplexity O(1)"""
        oldhead = self.head
        self.head = head.next
        return oldhead
    
    def replaceMin(self,obj):
        """bad function. its going to destroy the queue add algorythm, and it makes no sence"""
        self.head = Node(self.head,obj,self.head.prio)

    
def readListFile(file):
    List = open(file,"r").read().split()
    #print(List)
    #convert the list in my own datatype.. a bit useless but there i know the internal structure
    a = prioQueue()
    for element in List:
        #print(element)
        #print (type(element))
        if type(element) is str:
            a.__add__(element,element)
            #print(int(element))
    
    return a   

if __name__ == "__main__":
    Words = readListFile("words.dat")
    
    print(str(Words))
