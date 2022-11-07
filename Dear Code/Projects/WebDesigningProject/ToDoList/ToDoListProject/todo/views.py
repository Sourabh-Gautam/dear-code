from django.shortcuts import render

# Create your views here.
def showToDo(request):
    print("sourabh")
    print(request.GET['add'])

    return render(request, 'todo/mytodo.html')