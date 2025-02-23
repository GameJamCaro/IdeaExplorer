
class Thread{
  get name(): string {
    return <string>this._name;
  }

  set name(value: string) {
    this._name = value;
  }
    id: number | undefined;
    private _name: string | undefined;
    contents!: Content[];
    authors!: Author[];


    public addContent(content: Content): void {
        this.contents.push(content);
    }

    public addAuthor(author: Author): void {
        this.authors.push(author);
    }

    public getAuthor(): Author {
        return this.authors[0];
    }

    public getContent(): Content {
        return this.contents[0];
    }

}
