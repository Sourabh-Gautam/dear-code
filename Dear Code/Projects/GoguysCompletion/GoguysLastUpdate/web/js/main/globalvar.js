// shopobj var contains a parsed json javascript object having shopname as keys and icons as values
var shopobj;

// categoryobj var contains a parsed json js object having shopname as keys and array containing categories as values
var categoryobj;

//these shop variables are array which contains all their products and their all details

var groceryProducts = [];
var stationeryProducts = [];
var cosmeticsProducts = [];
var fruitsProducts = [];
var vegetablesProducts = [];

// start and end tell to the server range of product fetch from the database
var start = 1;
var end = 11;
var defaultStart = 1;
var defaultEnd = 11;
var increment = 5;

// active shop
var activeShop='Grocery';
var activeShop2='Grocery';

// active category
var activeCategory='All';

// product resize when the user has pressed on burger and then try to navigate over the shops it comes into the picture while scrolling.
var resizeCard;

//products will hold all the products where indexing used as key and js object containing all details of product as value

var products;

// productsName will hold all the products name and it mainly use for searching
var productsName;

// searchTriggered will tell to the scrolling that the elements to be fetched on scroll is related to the search input or not

var searchTriggered = false;

// this object will contain the items id added by the user in their cart

var cartItems = new Object();

// this object contains id as key and price  as value

var itemsPrice = new Object();
